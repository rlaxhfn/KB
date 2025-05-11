package ch15.sec02.exam03;

import ch15.sec02.exam01.Board;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<Board> list = new LinkedList<>();

        list.add(new Board("제목1", "내용1", "작가1"));
        list.add(new Board("제목2", "내용2", "작가2"));
        list.add(new Board("제목3", "내용3", "작가3"));
        list.add(new Board("제목4", "내용4", "작가4"));
        list.add(new Board("제목5", "내용5", "작가5"));

        System.out.println("총 객체 수: "+list.size());
        Board board=list.get(2);
        System.out.println(board.getSubject()+" "+board.getContent()+" "+board.getWriter());
        System.out.println();

        for(int i=0; i<list.size(); i++){
            Board temp=list.get(i);
            System.out.println(temp.getSubject()+" "+temp.getContent()+" "+temp.getWriter());
        }

        list.remove(2);
        list.remove(2);

        System.out.println();
        for(Board temp:list){
            System.out.println(temp.getSubject()+" "+temp.getContent()+" "+temp.getWriter());
        }
    }
}
