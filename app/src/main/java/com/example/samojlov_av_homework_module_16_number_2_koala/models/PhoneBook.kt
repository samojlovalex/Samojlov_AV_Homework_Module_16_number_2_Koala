package com.example.samojlov_av_homework_module_16_number_2_koala.models

data class PhoneBook(val name: String, val phone: String) {

    companion object {
        val phoneBook = mutableListOf(
            PhoneBook("Гарри Поттер", "+1 (781) 452-40-77"),
            PhoneBook("Воландеморт", "+1 (781) 452-42-99"),
            PhoneBook("Гендальф белый","+64 9 123 4567"),
            PhoneBook("Дарт Вейдер","+1 (213) 252-4023"),
            PhoneBook("Микки Маус","+1 (714)-781-4636"),
            PhoneBook("Илья Муромец","+7 (49234) 9-23-85"),
            PhoneBook("Воланд","+7 (495) 699-53-66"),
            PhoneBook("СейлорМун","+81 (03) 1234-5678"),
            PhoneBook("Геральт из Ривии","+48 22 621 59 54"),
            PhoneBook("Дед Мороз","8 (81738) 2-66-73")
        )
    }
}