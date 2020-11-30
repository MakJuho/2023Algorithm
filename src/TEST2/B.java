
package TEST2;

import TEST.*;

class C extends A{

	
	public void func() {
		
		A gc = new A();
		System.out.println(gc.getId());
	}
		
		
//		System.out.println(gc.getId());
		
		
	
}

public class B{
	public static void main(String[] args) {
		C gb = new C();
		gb.func();
	}
}
