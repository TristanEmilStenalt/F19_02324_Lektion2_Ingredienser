public class Main {

    public static void main(String[] args) {
	// write your code here

        IData data = new DemoData();
        IUI ui = new TUI(data);
//        while (true){
//            ui.showMenu();
//        }
        ui.showMenu();


    }
}
