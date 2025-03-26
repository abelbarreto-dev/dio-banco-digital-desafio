import com.abel.bank.core.Bank;
import com.abel.bank.core.BankInterface;
import com.abel.bank.enums.EnumAccountType;
import com.abel.bank.exceptions.BankAccountException;
import com.abel.bank.records.BankAccountRecord;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        try {
            var client1 = new BankAccountRecord("abel", EnumAccountType.SAVING, "1000");

            BankInterface bank = new Bank();

            bank.newBankAccount(client1);

            bank.deposit("abel", new BigDecimal("500"));

            bank.queryBalance("abel");

            bank.withdraw("abel", new BigDecimal("250"));

            bank.queryBalance("abel");

            // -------------

            System.out.println("part ii -------------".toUpperCase());

            var client2 = new BankAccountRecord("paulo", EnumAccountType.CHECKING, "3500");

            bank.newBankAccount(client2);

            bank.queryBalance("abel");
            bank.queryBalance("paulo");

            bank.transfer("paulo", "abel", new BigDecimal("750"));

            bank.queryBalance("abel");
            bank.queryBalance("paulo");

            bank.deleteAccount("abel");
            bank.deleteAccount("paulo");
        }
        catch (BankAccountException be) {
            System.err.println(be.getMessage());
        }
    }
}