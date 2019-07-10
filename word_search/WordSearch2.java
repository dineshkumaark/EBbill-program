import java.util.*;
public class WordSearch2 {
    public static List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i < words.length;i++){
            if(exist(board,words[i])){
                al.add(words[i]);
            }
        }
        Collections.sort(al);
        return al;
    }

    static boolean exist(char[][] board,String word){
        boolean found = false;
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    found = isExist(board,word,i,j,0);
                    if(!found){
                        continue;
                    }
                    return found;
                }
            }
        }
        return false;
    }
    
    static boolean isExist(char[][] board,String word,int i,int j,int count){
        if(count == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)){
            return false;
        }
        if(board[i][j] == word.charAt(count)){
            count++;
        }
        char c = board[i][j];
        board[i][j] = ' ';
        boolean found = isExist(board,word,i+1,j,count) || isExist(board,word,i,j+1,count) || isExist(board,word,i-1,j,count) || isExist(board,word,i,j-1,count);
        board[i][j] = c;
        return found;
    }
    public static void main(String[] args) {
        char[][] grid = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] word = {"oath","pea","eat","rain"};
        List<String> al = findWords(grid,word);
        for(String found : al){
        System.out.println(found);
        }
    }
}