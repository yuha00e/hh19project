// 숫자 야구 게임

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
// 1. 랜덤 객체 생성
        Random random = new Random();

// 2. 컴퓨터 배열 생성
        int[] intArray = new int[3];

// 3. 중복 제거한 랜덤 구하기
        for (int i = 0; i < 3; i++) {
            intArray[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (intArray[i] == intArray[j]) {
                    i--;
                }
            }
        }

// 컴퓨터의 숫자 배열 출력 (참고용)
// for (int i = 0; i < 3; i++) {
// System.out.print(intArray[i]);
// }

// 사용자 입력 숫자 배열 생성

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        Scanner sc = new Scanner(System.in);
        int[] myNumber = new int[3];

// Strike, Ball, howMany(도전 횟수) 0으로 변수 초기화
        int Strike = 0;
        int Ball = 0;
        int howMany = 0;


// 컴퓨터의 숫자와 사용자의 숫자가 일치하는지 여부 판별
// 정답을 맞추기 전까지 반복
        while (!(Arrays.equals(intArray, myNumber))) {
// 사용자의 숫자 다시 입력 받아 초기화
            String num = sc.next();
            System.out.println(howMany + 1 + "번째 시도 : " + num);

// Stirng으로 입력 받은 사용자 숫자를 int형 배열로 형변환
            String[] myString = num.split("");
            for (int i = 0; i < myString.length; i++) {
                myNumber[i] = Integer.parseInt(myString[i]);
            }

// 정답을 못 맞추는 경우
// 컴퓨터의 숫자 배열을 하나하나씩 사용자의 숫자와 비교 (3x3=9, 모든 경우의 수)
            for (int i = 0; i < intArray.length; i++) {
                for (int j = 0; j < myNumber.length; j++) {
// 숫자 값 동일, 숫자 위치 동일한 경우
                    if (intArray[i] == myNumber[j] && i == j) {
// Strike 횟수 누적
                        Strike++;
                    }
// 숫자 값만 동일한 경우
                    else if (intArray[i] == myNumber[j] && i != j) {
// Ball 횟수 누적
                        Ball++;
                    }
                }
            }
// 틀린 횟수 누적
            howMany++;

// 예시 형식에 맞춰 Strike, Ball 출력
            if (Ball == 3) {
                System.out.println(Ball + "B");
            } else if (Strike == 3) {
                System.out.println(Strike + "S");
            } else {
                System.out.println(Ball + "B" + Strike + "S");
            }

// 컴퓨터의 숫자와 사용자의 숫자 비교 후 다시 loop 진행을 위해 변수 초기화
// Strike, Ball 0으로 초기화
            Strike = 0;
            Ball = 0;

        }
// 결과 출력하기
        System.out.println(howMany + "번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
    }
}

