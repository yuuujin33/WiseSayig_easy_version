package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wiseSayingList = new ArrayList<>();
        long id = 1;
        System.out.println("== 명언앱 ==");
        while (true) {
            System.out.printf("명령)");
            String command = sc.nextLine();


            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.printf("명언: ");
                String content = sc.nextLine();
                System.out.printf("작가: ");
                String author = sc.nextLine();
                System.out.println(id + "번 명령이 등록되었습니다.");

                WiseSaying WiseSaying = new WiseSaying(id, author, content);
                wiseSayingList.add(WiseSaying);

                id++;

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                for (WiseSaying wiseSaying : wiseSayingList) {
                    System.out.printf("%d, %s, %s \n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
                }
            } else if (command.equals("삭제")) {
                System.out.println("삭제할 번호(id)를 입력해주세요");
                long removeId = sc.nextLong();
                sc.nextLine();

                for (WiseSaying wiseSaying : wiseSayingList) {
                    if (wiseSaying.getId() == removeId) {
                        wiseSayingList.remove(wiseSaying);
                    }
                }
                System.out.println(removeId + "번 명언이 삭제되었습니다.");
            } else if (command.equals("수정")) {
                System.out.println("수정할 번호(id)를 입력해주세요");
                long modifyId = sc.nextLong();
                sc.nextLine();

                for (WiseSaying wiseSaying : wiseSayingList) {
                    if (wiseSaying.getId() == modifyId) {
                        System.out.printf("기존 명언: %s\n", wiseSaying.getContent());
                        System.out.printf("명언: ");
                        String content = sc.nextLine();

                        System.out.printf("기존 작가: %s\n", wiseSaying.getAuthor());
                        System.out.printf("작가: ");
                        String author = sc.nextLine();

                        wiseSaying.setAuthor(author);
                        wiseSaying.setContent(content);
                        System.out.println(modifyId + "번 명언이 수정되었습니다.");
                    }
                }
            }
        }
        sc.close();
    }


}

class WiseSaying {
    private long id;
    private String author;
    private String content;

    WiseSaying(long id, String author, String content) {

        this.id = id;
        this.author = author;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

