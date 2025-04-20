package application;

/*
사용자로부터 정수 배열을 입력받습니다. 버블 정렬, 선택 정렬 등의 간단한 정렬 알고리즘을 구현하여 배열을 정렬합니다.
정렬 전후의 배열 상태를 출력합니다.
결과물로 정렬 전후의 배열 상태를 보여주는 스크린샷을 제출합니다.
 */

import java.util.Scanner;

public class ArraySort{

    public static void bubbleSort(int[] arr){
        //static을 쓰면 클래스명으로 바로 메서드 호출 가능
        // 인접한 두 값을 비교하여 큰 값을 뒤로 이동, 전체 순회 계속 반복
        int len = arr.length;
        for(int i=0 ; i<len-1 ; i++){
            for (int j=0 ; j<len-i-1 ; j++){
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        //가장 작은 값을 찾아서 앞으로 보냄
        int len = arr.length;
        for (int i=0 ; i<len-1 ; i++){
            int minIndex = i;
            for (int j=i+1 ; j<len ; j++){
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void printArray(int[] arr){
        // System.out.println(arr); 이렇게 하면 해쉬코드 나옴

        for (int a : arr){
            System.out.print(a+" "); //println은 개행(엔터)포함, print는 그냥 쭉 출력!
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정렬할 정수 배열의 크기를 입력하세요: ");
        int len = sc.nextInt();
        int arr[] = new int[len];

        System.out.println("배열에 들어갈 정수들을 입력해주세요: ");

        for (int i=0 ; i<len ; i++){
            arr[i] = sc.nextInt();
        }

        /* 향상된 for 문은 int형이 들어가면 안되고 배열 또는 Iterable(리스트 같은 컬렉션)이 필요
        for (int i : len){
            arr[i] = sc.nextInt();
        }
         */

        System.out.println("정렬 전 배열: ");
        printArray(arr);

        int[] bubble = arr.clone();
        bubbleSort(bubble);
        System.out.println("\n버블 정렬 후 배열: ");
        printArray(bubble);

        // 선택 정렬 실행
        int[] selection = arr.clone();  // 원본 배열 복사
        selectionSort(selection);
        System.out.println("\n선택 정렬 후 배열: ");
        printArray(selection);

        sc.close();

    }
}