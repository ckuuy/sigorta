public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        Account account = accountManager.login();
        System.out.println("Hoşgeldiniz " + account.getUser().getFname() + " " +
                account.getUser().getLname());
        account.addAddress("Keçiören / Ankara");
        account.addAddress("Merkez / Kütahya");
        account.addAddress("Kaman / Kırşehir");
        account.addInsurance(new CarInsurance());
        account.showUserInfo();
    }
}