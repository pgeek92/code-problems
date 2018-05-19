/**
 * Determine a Winner
 * 
 * Assume there are two programmers with their hacker names as "Flash" and "Cisco". 
 * They both took part in a contest. The rules of the contest are:
 * 
 *
 * There will be 4 questions to solve, P, Q, R and S.
 * Initial score (before the start of the contest) of the 4 problems is s_p, s_q, s_r and s_s.
 * After each minutes, the score of the questions, P, Q, R and S, will decrease by  d_p, d_q, d_r 
 * and d_s respectively. The score cannot decrease below half (integer division) of 
 * the initial score for each question i.e. at a particular time, the score of the problems 
 * will be maximum of half of the initial score and the decreased score.
 * Flash submitted the solutions of the questions at time f_p, f_q, f_r and f_s. 
 * Cisco submitted the solutions of the questions at time c_p, c_q, c_r and c_s. 
 * Your task is to find winner of contest. The winner is the one who has more score. 
 * If the score of both the programmers is same, then winner will be the one who took 
 * less time to solve all the questions. If both the problems have same score and took 
 * same time to solve the questions, then print Tie.
 *
 * NOTE: All the times mentioned above are in minutes. Time taken to solve all the questions is the time at which programmers submitted the last solution.
 *
 *
 * Input Format
 *
 * First line of input contains an integer T, denoting number of test cases.
 *
 * First line of each test case contains 4 space separated integers s_p, s_q, s_r, s_s 
 * denoting the initial scores for each problems.
 *
 * Second line of each test case contains 4 space separated integers d_p, d_q, d_r, d_s 
 * denoting the decrease in each problem's score after each minute.
 *
 * Third line of each test case contains 4 space separated integers f_p, f_q, f_r, f_s 
 * denoting the time when Flash submitted his solutions.
 *
 * Fourth line of each test case contains 4 space separated integers c_p, c_q, c_r, c_s 
 * denoting the time when Cisco submitted his solutions.
 *
 * 
 *
 * Output Format
 *
 * Print the winner of the competition - Flash or Cisco. If both the problems have same score 
 * and took same time to solve the questions, then print Tie.
 *
 * 
 *
 * Constraints
 *
 * 1 <= T <= 105
 *
 * 100 <= s_p, s_q, s_r, s_s <= 106
 *
 * 0 <= d_p, d_q, d_r, d_s <= 106
 *
 * 0 <= f_p, f_q, f_r, f_s <= 106
 *
 * 0 <= c_p, c_q, c_r, c_s <= 106
 *
 * Sample Input
 * 1
 * 1000 2000 3000 4000
 * 1 2 30 40
 * 110 10 7 8
 * 15 30 45 20
 * 
 * Sample Output
 * Flash
 * 
 * Explanation
 * Flash submitted the solutions at time 110, 10, 7 and 8 for the questions P, Q, R and S, 
 * respectively. For question P he will get score of only 1000 - 110 * 1 = 890. For question Q 
 * he will get 2000 - 10 * 2 = 1980. Similarly, for question R and S, he will get 2790 and 3680. 
 * Therefore, the total score is 9340. Total time he took to solve all problems is 110.
 *
 * Cisco submitted the solutions at time 15, 30, 45 and 55 for the questions P, Q, R and S, 
 * respectively. So he will get 985, 1940, 1650 and 3200 score for the questions P, Q, R and S, 
 * respectively. Total score is 7775. Total time he took to solve all problems is 45.
 *
 * Since Flash's total score is greater than Cisco's, Flash is the winner.
 *
 * Note: Your code should be able to convert the sample input into the sample output. 
 * However, this is not enough to pass the challenge, because the code will be run on 
 * multiple test cases. Therefore, your code must solve this problem statement.
 * 
 * Time Limit: 1.0 sec(s) for each input file
 * Memory Limit: 256 MB
 * Source Limit: 1024 KB
 * Marking Scheme: Marks are awarded if any testcase passes
 * Allowed Languages: C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, 
 * Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, 
 * Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, Racket, Ruby, Rust, Scala, 
 * Swift, Visual Basic
 * 
 */

package challenges.trustingSocial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DetermineWinner {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Map<Integer, Integer> flashScoreToTimeTaken = new HashMap<Integer, Integer>();
        Map<Integer, Integer> ciscoScoreToTimeTaken = new HashMap<Integer, Integer>();
        int flashScore = 0;
        int ciscoScore = 0;
        int flashTime = 0;
        int ciscoTime = 0;
        for(int i = 0; i < T; i++){
            String[] initialScores = br.readLine().split(" ");
            String[] decreasedScoreEveryMinute = br.readLine().split(" ");
            String[] flashTiming = br.readLine().split(" ");
            String[] ciscoTiming = br.readLine().split(" ");
            flashScoreToTimeTaken = checkWinner(initialScores, decreasedScoreEveryMinute, flashTiming);
            ciscoScoreToTimeTaken = checkWinner(initialScores, decreasedScoreEveryMinute, ciscoTiming);
            for(Integer key : flashScoreToTimeTaken.keySet()){
                flashScore = key;
                flashTime = flashScoreToTimeTaken.get(key);
            }
            
            for(Integer key : ciscoScoreToTimeTaken.keySet()){
                ciscoScore = key;
                ciscoTime = ciscoScoreToTimeTaken.get(key);
            }
            
            if(flashScore > ciscoScore){
                System.out.println("Flash");
            }else if(flashScore < ciscoScore) {
                System.out.println("Cisco");
            }else if(flashScore == ciscoScore){
                if(flashTime < ciscoTime){
                    System.out.println("Flash");
                }else if(flashTime > ciscoTime){
                    System.out.println("Flash");
                }else if(flashTime == ciscoTime){
                    System.out.println("Tie");
                }
            }
        }
    }
    
    public static Map<Integer, Integer> checkWinner(String[] initialScores, String[] decreasedScoreEveryMinute, String[] userTiming){
        int totalScore = 0;
        int totalTimeTaken = 0;
        int length = initialScores.length;
        int eachSubjectScore = 0;
        int[] userTimingArr = new int[4];
        Map<Integer, Integer> scoreToTimeTaken = new HashMap<Integer, Integer>();
        for(int i = 0; i < length; i++){
            eachSubjectScore = Integer.parseInt(initialScores[i]) - Integer.parseInt(decreasedScoreEveryMinute[i]) * Integer.parseInt(userTiming[i]);
            if(eachSubjectScore <= Integer.parseInt(initialScores[i])/2){
                eachSubjectScore = Integer.parseInt(initialScores[i])/2;
            }
            totalScore += eachSubjectScore;
            userTimingArr[i] = Integer.parseInt(userTiming[i]);
        }
        Arrays.sort(userTimingArr);
        totalTimeTaken = userTimingArr[3];
        scoreToTimeTaken.put(totalScore, totalTimeTaken);
        return scoreToTimeTaken;
    }
}
