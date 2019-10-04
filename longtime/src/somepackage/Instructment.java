package somepackage;

public abstract class Instructment {
	
	public abstract void play ();
	public static void main(String[] args) {
		Instructment instructment = new Instructment() {
			
			@Override
			public void play() {
				System.out.println("I'm playing the gita.");
				
			}
		};
		instructment.play();
	}

}
