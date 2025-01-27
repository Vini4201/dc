import java.util.Scanner;

class LoadBalancer {
        static void printLoad(int servers, int Processes) {
                int each = Processes / servers;
                int extra = Processes % servers;
                int total = 0;
                for (int i = 0; i < servers; i++) {
                        if (extra-- > 0)
                                total = each + 1;
                        else
                                total = each;
                        System.out.println("Servers " + (char) ('A' + i) + " has " + total + " Processes ");
                }
        }

        public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the number of Servers and Processes: ");
                int servers = sc.nextInt();
                int Processes = sc.nextInt();

                while (true) {
                        printLoad(servers, Processes);
                        System.out.print(
                                        "1. Add Servers \n 2. Remove Server \n 3. Add Processes \n 4. Remove processes \n 5. Exit \n");
                        switch (sc.nextInt()) {
                                case 1:
                                        System.out.println("How many more servers?: ");
                                        servers += sc.nextInt();
                                        break;
                                case 2:
                                        System.out.println("How many servers to remove?: ");
                                        servers -= sc.nextInt();
                                        break;
                                case 3:
                                        System.out.println("How many more Processes?: ");
                                        Processes += sc.nextInt();
                                        break;
                                case 4:
                                        System.out.println("How many Processes to remove?: ");
                                        Processes -= sc.nextInt();
                                        break;
                                case 5:
                                        return;
                        }
                }
        }
}