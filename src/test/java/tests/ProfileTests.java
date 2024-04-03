package tests;

import extensions.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;

public class ProfileTests extends TestBase {
    ProfilePage profilePage = new ProfilePage();
    @Test
    @DisplayName("Проверка на пустой список книг")
    @WithLogin
    void bookListIsEmpty() {
            profilePage.openPage();
            profilePage.checkEmptyCells();
            profilePage.checkNoDataMessage();
    }
}
