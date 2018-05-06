/**
 * Roy wants to change his profile picture on Facebook. Now Facebook has some restriction over the dimension of picture that we can upload.
 * Minimum dimension of the picture can be L x L, where L is the length of the side of square.
 * 
 * Now Roy has N photos of various dimensions.
 * Dimension of a photo is denoted as W x H 
 * where W - width of the photo and H - Height of the photo
 * 
 * When any photo is uploaded following events may occur:
 * 
 * [1] If any of the width or height is less than L, user is prompted to upload another one. Print "UPLOAD ANOTHER" in this case.
 * [2] If width and height, both are large enough and 
 * (a) if the photo is already square then it is accepted. Print "ACCEPTED" in this case.
 * (b) else user is prompted to crop it. Print "CROP IT" in this case.
 * 
 * (quotes are only for clarification)
 *  
 * Given L, N, W and H as input, print appropriate text as output.
 * 
 * Input:
 * First line contains L.
 * Second line contains N, number of photos.
 * Following N lines each contains two space separated integers W and H.
 * 
 * Output:
 * Print appropriate text for each photo in a new line.
 * 
 * Constraints:
 * 1 <= L,W,H <= 10000
 * 1 <= N <= 1000
 * 
 * SAMPLE INPUT 
 * 180
 * 3
 * 640 480
 * 120 300
 * 180 180
 * 
 * SAMPLE OUTPUT 
 * CROP IT
 * UPLOAD ANOTHER
 * ACCEPTED
 * 
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic
 * 
 */

package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class RoyAndProfilePicture {

	public static void main(String args[] ) throws Exception {

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
