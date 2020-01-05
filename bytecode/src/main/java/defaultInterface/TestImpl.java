package defaultInterface;

public class TestImpl implements ITest_1,ITest_2 {

    @Override
    public void testDefault() {
        ITest_2.super.testDefault();
    }
}
