import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
        accounts.add(new Enterprise(new User("Ali","Orhan","ali@orhan","123","muhendis",25)));
        accounts.add(new Individual(new User("Mehmet","Orhan","mehmet@orhan","123","mufettis",36)));
        accounts.add(new Individual(new User("Emre","Orhan","emre@orhan","123","memur",40)));
    }
    public Account login() {
        String[] infos = getLoginInfos();
        Account tempAccount = null;

        for (Account account : accounts) {
            if (account.getUser().getEmail().equals(infos[0])) {
                tempAccount = account;
                break;
            }
        }
        if (tempAccount != null) {
            try {
                tempAccount.login(infos[0], infos[1]);
            } catch (InvalidAuthenticationException e) {
                throw new RuntimeException(e);
            }
        }
        return tempAccount;
    }

    public String[] getLoginInfos() {
        String[] infos = new String[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen giriş yapmak için bilgilerinizi giriniz:");
        System.out.print("E-Posta: ");
        infos[0] = scanner.nextLine();
        System.out.print("Şifre: ");
        infos[1] = scanner.nextLine();
        scanner.close();
        return infos;
    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(TreeSet<Account> accounts) {
        this.accounts = accounts;
    }
}