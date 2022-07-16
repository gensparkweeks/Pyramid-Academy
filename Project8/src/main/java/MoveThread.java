public class MoveThread extends Thread{
    BoardGame board;
    public MoveThread(BoardGame board){
        this.board = board;
    }
    @Override
    public void run(){

        while (true){

            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            board.repaint();
        }
    }

}
