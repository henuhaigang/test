package test;

public class TestTry {
	public String f() {
		try {
			int b = 1 / 0;
		} catch (Exception e) {
			e.printStackTrace();
			return "exception";
		} finally {
			System.out.println("123");
		}
		return "ok";
	}

	public static void main(String[] args) {
		String s = new TestTry().f();
		System.out.println(s);
	}
}
