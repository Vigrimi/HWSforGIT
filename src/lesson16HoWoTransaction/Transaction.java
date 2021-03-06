package lesson16HoWoTransaction;

import java.util.Locale;

public class Transaction
{
    private String uuid;
    private long sum;
    private Account account;

    public Transaction(String uuid, long sum, Account account)
    {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public Account getAccount() {
        return account;
    }

    public String getAccountToString()
    {
        String accountToString = this.account.toString();
        return accountToString;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



    @Override
    public String toString() {
        return "Transaction{" +
                "uuid='" + uuid + '\'' +
                ", sum=" + sum +
                ", account=" + account +
                '}';
    }
}