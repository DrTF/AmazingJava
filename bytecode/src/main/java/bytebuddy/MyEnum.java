package bytebuddy;

public enum MyEnum {
    A("a"),
    B("b"),
    C("c");

    private String name;

    MyEnum(String name) {
        this.name = name;
    }
}
