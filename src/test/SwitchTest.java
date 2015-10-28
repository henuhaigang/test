package test;

public class SwitchTest {
	public static void main(String[] args) {
new SwitchTest().f();
	}

	public int f() {
		int j = 1;
		int x = 2;
		switch (x) {
		case 1:
			j++;
		case 2:
			j++;
		default:
			break;
		}
		System.out.println(x+j);
		return x + j;
	}
}
