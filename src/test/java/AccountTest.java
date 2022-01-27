import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean isTrue;

    public AccountTest(String name,boolean isTrue){
        this.name = name;
        this.isTrue = isTrue;
    }

    @Parameterized.Parameters(name = "name = {0} | isTrue = {1}")
    public static Object[] getName(){
        return new Object[] [] {
                {"Павел Петров", true},
                {"Ю И", true},
                {"Тимофей Дзержинский", true},
                {"ЮИ",false},
                {"1234 4321",true},
                {"12345678 123456789",true},
                {"Здесь ровно20символв",false},
                {" Алекс Праведный", false},
                {"Жора Качинский ", false},
                {"Дора  Дора", false},
                {null,false}
        };
    }

    @Test
    public void checkPrint(){
        Account account =  new Account(name);
        boolean canPrint = account.checkNameToEmboss();
        assertEquals("В методе печати имя/фамилия возникла ошибка", canPrint, isTrue);

    }
}

