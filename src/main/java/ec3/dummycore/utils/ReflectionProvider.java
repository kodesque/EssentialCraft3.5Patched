package ec3.dummycore.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionProvider {
    public static final DummyCore.Utils.ReflectionProvider instance = new DummyCore.Utils.ReflectionProvider();
    private Class<?> workingWith;
    private Object accessed;
    private boolean isAccessing;
    private boolean hardAccess;

    public ReflectionProvider() {
    }

    public boolean setTo(String name, Object setTo) {
        this.c();

        try {
            Field f = this.getField(name);
            boolean accessed = f.isAccessible();
            if (!accessed && this.hardAccess) {
                f.setAccessible(true);
            }

            f.set(accessed, setTo);
            if (this.hardAccess) {
                f.setAccessible(accessed);
            }

            return true;
        } catch (Exception var5) {
            return false;
        }
    }

    public float getFloatFrom(String name) {
        this.c();

        try {
            Field f = this.getField(name);
            boolean accessed = f.isAccessible();
            if (!accessed && this.hardAccess) {
                f.setAccessible(true);
            }

            float ret = f.getFloat(accessed);
            if (this.hardAccess) {
                f.setAccessible(accessed);
            }

            return ret;
        } catch (Exception var5) {
            return Float.NaN;
        }
    }

    public double getDoubleFrom(String name) {
        this.c();

        try {
            Field f = this.getField(name);
            boolean accessed = f.isAccessible();
            if (!accessed && this.hardAccess) {
                f.setAccessible(true);
            }

            double ret = f.getDouble(accessed);
            if (this.hardAccess) {
                f.setAccessible(accessed);
            }

            return ret;
        } catch (Exception var6) {
            return Double.NaN;
        }
    }

    public int getIntFrom(String name) {
        this.c();

        try {
            Field f = this.getField(name);
            boolean accessed = f.isAccessible();
            if (!accessed && this.hardAccess) {
                f.setAccessible(true);
            }

            int ret = f.getInt(accessed);
            if (this.hardAccess) {
                f.setAccessible(accessed);
            }

            return ret;
        } catch (Exception var5) {
            return Integer.MIN_VALUE;
        }
    }

    public boolean getBoolFrom(String name) {
        this.c();

        try {
            Field f = this.getField(name);
            boolean accessed = f.isAccessible();
            if (!accessed && this.hardAccess) {
                f.setAccessible(true);
            }

            boolean ret = f.getBoolean(accessed);
            if (this.hardAccess) {
                f.setAccessible(accessed);
            }

            return ret;
        } catch (Exception var5) {
            return false;
        }
    }

    public Object getFrom(String name) {
        this.c();

        try {
            Field f = this.getField(name);
            boolean accessed = f.isAccessible();
            if (!accessed && this.hardAccess) {
                f.setAccessible(true);
            }

            Object ret = f.get(accessed);
            if (this.hardAccess) {
                f.setAccessible(accessed);
            }

            return ret;
        } catch (Exception var5) {
            return null;
        }
    }

    public Object create(Class<?>[] parParams, Object[] parObj) {
        this.c();

        try {
            Constructor<?> c = this.getConstructor(parParams);
            boolean accessed = c.isAccessible();
            if (!accessed && this.hardAccess) {
                c.setAccessible(true);
            }

            Object ret = c.newInstance(parObj);
            if (this.hardAccess) {
                c.setAccessible(accessed);
            }

            return ret;
        } catch (Exception var6) {
            return null;
        }
    }

    public Object invoke(String name, Class<?>[] parParams, Object[] parObj) {
        this.c();

        try {
            Method m = this.getMethod(name, parParams);
            boolean accessed = m.isAccessible();
            if (!accessed && this.hardAccess) {
                m.setAccessible(true);
            }

            Object ret = m.invoke(accessed, parObj);
            if (this.hardAccess) {
                m.setAccessible(accessed);
            }

            return ret;
        } catch (Exception var7) {
            return null;
        }
    }

    public Constructor<?> getConstructor(Class<?>... params) {
        this.c();

        try {
            return this.workingWith.getConstructor(params);
        } catch (Exception var5) {
            try {
                return this.workingWith.getDeclaredConstructor(params);
            } catch (Exception var4) {
                return null;
            }
        }
    }

    public Method getMethod(String name, Class<?>... params) {
        this.c();

        try {
            return this.workingWith.getMethod(name, params);
        } catch (Exception var6) {
            try {
                return this.workingWith.getDeclaredMethod(name, params);
            } catch (Exception var5) {
                return null;
            }
        }
    }

    public Field getField(String name) {
        this.c();

        try {
            return this.workingWith.getField(name);
        } catch (Exception var5) {
            try {
                return this.workingWith.getDeclaredField(name);
            } catch (Exception var4) {
                return null;
            }
        }
    }

    public Class<?> getSetClass() {
        this.c();
        return this.workingWith;
    }

    public boolean setClass(String classPath) {
        this.c();

        try {
            this.workingWith = Class.forName(classPath);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public boolean setClass(Object clazz) {
        this.c();
        this.workingWith = clazz.getClass();
        this.accessed = clazz;
        return true;
    }

    public void access(Object obj) {
        this.c();
        this.accessed = obj;
    }

    private boolean c() {
        if (!this.isAccessing) {
            throw new IllegalStateException("Reflection Provider not running!");
        } else {
            return this.isAccessing;
        }
    }

    public void start() {
        if (this.isAccessing) {
            throw new IllegalStateException("Reflection Provider already running!");
        } else {
            this.isAccessing = true;
        }
    }

    public void end() {
        if (!this.isAccessing) {
            throw new IllegalStateException("Reflection Provider not running!");
        } else {
            this.isAccessing = false;
            this.workingWith = null;
            this.accessed = null;
            this.hardAccess = false;
        }
    }

    public void enableHardAccess(boolean b) {
        this.c();
        this.hardAccess = b;
    }

    public Object getCurrentObj() {
        this.c();
        return this.accessed;
    }

    public Object setCurrentObj(Object obj) {
        this.c();
        this.accessed = obj;
        return this.accessed;
    }
}
