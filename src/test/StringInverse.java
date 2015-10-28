package test;

public class StringInverse {
public static void main(String[] args) {
	String s1="just do it !";
	String arr1[]=s1.split(" ");
	String arr2[]=new String[arr1.length];
	for(int i=arr1.length-1;i>=0;i--){
		arr2[arr1.length-1-i]=arr1[i];
	}
	//String s2=
	for(int i=0;i<arr1.length;i++){
		System.out.print(arr2[i]+" ");
	}
}
}
