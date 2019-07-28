/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/roy-and-profile-picture/description/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoyAndProfilePicture {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lengthOfSideOfSquare = Integer.parseInt(br.readLine());
        int noOfPhotos = Integer.parseInt(br.readLine());
        for(int i = 0; i < noOfPhotos; i++){
            String[] dimensionOfPhotos = br.readLine().split(" ");
            messageToUser(dimensionOfPhotos, lengthOfSideOfSquare);
        }
	}

	public static void messageToUser(String[] dimensionOfPhotos, int lengthOfSideOfSquare){
        int W = Integer.parseInt(dimensionOfPhotos[0]);
        int H = Integer.parseInt(dimensionOfPhotos[1]);
        if(W < lengthOfSideOfSquare || H < lengthOfSideOfSquare){
            System.out.println("UPLOAD ANOTHER");
        }else{
            if(W==H){
                System.out.println("ACCEPTED");
            }else{
                System.out.println("CROP IT");
            }
        }
    }
}
