package volatilekeyword;

public class SecondClass{
	
	   boolean var = false;

	
	public void toogleValue() {
	
		   var = !var;   
		   printvar();

	}

	public void checkVariable() {
		try {
			while (!var) {
				printvar();
				Thread.sleep(20);
			}
			System.out.println("============================================================");
			Thread.sleep(600);
			printvar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void printvar() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("var :" + String.valueOf(var));
	}


}
