package ec3.dummycore.ASM;

import DummyCore.Utils.Notifier;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;

import java.util.Arrays;
import java.util.List;

public class DCASMManager implements IClassTransformer {
    public DCASMManager() {
    }

    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (basicClass != null) {
            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(basicClass);
            classReader.accept(classNode, 0);
            if (classNode.invisibleAnnotations != null && classNode.invisibleAnnotations.size() > 0) {
                boolean checkClass = false;

                for(int i = 0; i < classNode.invisibleAnnotations.size(); ++i) {
                    AnnotationNode node = (AnnotationNode)classNode.invisibleAnnotations.get(i);
                    if (node.desc.equalsIgnoreCase("LDummyCore/Utils/DCASMCheck;")) {
                        checkClass = true;
                        break;
                    }
                }

                if (checkClass) {
                    return this.handleClass(name, transformedName, basicClass, classNode, classReader);
                }
            }
        }

        return basicClass;
    }

    public byte[] handleClass(String name, String transformedName, byte[] basicClass, ClassNode cn, ClassReader cr) {
        Notifier.notifyCustomMod("DummyCoreASM", "Class " + name + " has requested a DummyCore ASM check via DummyCore/Utils/DCASMCheck annotation. Examining...");
        String[] checkedClss = new String[0];

        for(int i = 0; i < cn.invisibleAnnotations.size(); ++i) {
            AnnotationNode node = (AnnotationNode)cn.invisibleAnnotations.get(i);
            if (node.desc.equalsIgnoreCase("LDummyCore/Utils/ExistanceCheck;") && node.values != null && node.values.size() > 0) {
                Notifier.notifyCustomMod("DummyCoreASM", "Class " + name + " has requested a DummyCore ASM check on it's implementations via DummyCore/Utils/ExistanceCheck annotation. Examining...");
                List<?> classes = (List)List.class.cast(node.values.get(1));
                checkedClss = new String[classes.size()];
                checkedClss = (String[])String[].class.cast(classes.toArray(checkedClss));
                break;
            }
        }

        Notifier.notifyCustomMod("DummyCoreASM", "Class " + name + " has given the next interfaces to check: " + Arrays.asList(checkedClss));
        ClassWriter cw = new ClassWriter(1);
        if (checkedClss.length > 0) {
            for(int i = 0; i < checkedClss.length; ++i) {
                if (!this.classExists(checkedClss[i])) {
                    for(int j = 0; j < cn.interfaces.size(); ++j) {
                        if (((String)cn.interfaces.get(j)).equalsIgnoreCase(checkedClss[i].replace('.', '/'))) {
                            Notifier.notifyCustomMod("DummyCoreASM", "Class " + name + " has a " + (String)cn.interfaces.get(j) + " implementation, but the referenced class was not found. Removing the given interface.");
                            cn.interfaces.remove(j);
                            break;
                        }
                    }
                } else {
                    Notifier.notifyCustomMod("DummyCoreASM", "Class " + name + " has a " + checkedClss[i] + " implementation, and the referenced class was found. Skipping to the next interface...");
                }
            }
        }

        cn.accept(cw);
        Notifier.notifyCustomMod("DummyCoreASM", "Class " + name + " has been checked.");
        return cw.toByteArray();
    }

    boolean classExists(String s) {
        try {
            Class<?> c = Class.forName(s);
            return c != null;
        } catch (ClassNotFoundException var3) {
            return false;
        }
    }
}
