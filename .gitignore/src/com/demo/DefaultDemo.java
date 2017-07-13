package com.demo;

// now use default to give interface method its body
interface EmployeeActivity{
	default void showDetails(){
		System.out.println("Showing employee acitivities");
	}
}
interface PersonActivity{
	default void showDetails(){
		System.out.println("Showing person acitivities");
	}
}

// lets implement both interfaces
public class DefaultDemo implements EmployeeActivity, PersonActivity{
	// ?? what show method now
	
	// we need to declare our own show method 
	
	@Override
	// no problem here, because class is deciding what to do
	// my  own method now
	public void showDetails(){
		System.out.println("Showing class acitivities");
		// here we will decide what showDetails to be called
		EmployeeActivity.super.showDetails();
		PersonActivity.super.showDetails();
	}
	
	public static void main(String[] args) {
		DefaultDemo demo = new DefaultDemo();
		// method implementation is coming from interface
		demo.showDetails();
	}

}
