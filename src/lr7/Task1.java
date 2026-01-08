package lr7;



public class Task1 {
    private String str1;

    Task1(String strEx) {
        this.str1 = strEx;
    }

    Task1() { }

    @Override
    public String toString() {
        return """
    super
     Class name: %s
     str 1 %s
    """.formatted(
                this.getClass().getSimpleName(),
                this.getStr1()
        );
    }

    public String getStr1() {
        return str1;
    }
    public void setStr1(String str1) {
        this.str1 = str1;
    }
}
