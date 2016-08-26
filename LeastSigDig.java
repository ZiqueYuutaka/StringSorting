public class LeastSigDig{
	public static void sort(String[] a, int W){
		//Sort a[] on leading W characters.
		int N = a.length;
		int R = 256;	//Utilize extended ASCII values to sort
		String[] aux = new String[N];

		//Sort starting from the least significant digit
		for(int d = W-1; d>= 0; d--){
			int[] count = new int[R+1]; //use indices 1 - 256
			//Computer frequencies
			for(int i = 0; i < N; i++){
				count[a[i].charAt(d) + 1]++;
			}

			//Transform frequency into array indices
			for(int r = 0; r < R; r++){
				count[r+1] += count[r];
			}

			//Distribute to auxilary array
			for(int i = 0; i < N; i++){
				aux[count[a[i].charAt(d)]++] = a[i];
			}

			//Copy from auxilary array to orignal array
			for(int i = 0; i < N; i++){
				a[i] = aux[i];
			}


		}
	}

	public static void main(String[] args){

		String[] fromFile = null;
		int fileSize = 0;
		final String fileName = "D:\\Data_Structures\\String_Sorting\\" + 
										args[0];

		//Read in LicensePlates.txt
		try{
			java.io.File file = new java.io.File(fileName);
			java.util.Scanner input = new java.util.Scanner(file);
			fileSize = input.nextInt();
			input.nextLine(); //Skip newline character left in file
			fromFile = new String[fileSize];

			int i = 0;
			while(input.hasNext()){
				//System.out.println(input.nextLine());
				fromFile[i++] = input.nextLine();
			}

			input.close();

		}
		catch(java.io.IOException ex){
			System.out.println("FILE NOT FOUND");
			ex.printStackTrace();
		}

		//print out sorted array
		System.out.println("----STRINGS FROM FILE----");
		for(int i = 0; i < fileSize; i++){
			System.out.println(fromFile[i]);
		}		

		//pass in array and size of string
		LeastSigDig.sort(fromFile, 7);

		//print out sorted array
		System.out.println("----STRINGS SORTED----");
		for(int i = 0; i < fileSize; i++){
			System.out.println(fromFile[i]);
		}
		System.out.println();
	}
}