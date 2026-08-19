package ec3.dummycore.utils;

public class DummyData {
    public final String fieldName;
    public final String fieldValue;

    public DummyData(String field, String value) {
        this.fieldName = field;
        this.fieldValue = value;
    }

    public DummyData(String field, Object value) {
        this.fieldName = field;
        this.fieldValue = value.toString();
    }

    public String toString() {
        String ret = "";
        ret = ret.concat("||").concat(this.fieldName).concat(":").concat(this.fieldValue.toString());
        return ret;
    }

    public static DummyCore.Utils.DummyData makeNull() {
        return new DummyCore.Utils.DummyData("null", "null");
    }
}
