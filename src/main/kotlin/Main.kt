fun main() {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    val alphabetSize = alphabet.length

    // Ввод ключевого слова
    println("Введите ключевое слово:")
    val keyWord = readLine()?.uppercase() ?: ""

    // Ввод исходного текста
    println("Введите исходный текст:")
    val sourceText = readLine()?.uppercase() ?: ""

    // Проверка корректности ввода
    if (keyWord.isEmpty() || sourceText.isEmpty()) {
        println("Ошибка: ключевое слово и исходный текст не могут быть пустыми.")
        return
    }

    // Формируем последовательность сдвигов на основе ключевого слова
    val shifts = keyWord.map { alphabet.indexOf(it) + 1 }

    // Шифрование текста
    val encryptedText = StringBuilder()
    for (i in sourceText.indices) {
        val char = sourceText[i]
        val shift = shifts[i % shifts.size]

        if (char in alphabet) {
            val newIndex = (alphabet.indexOf(char) + shift) % alphabetSize
            encryptedText.append(alphabet[newIndex])
        } else {
            encryptedText.append(char) // Если символ не в алфавите, оставляем его без изменений
        }
    }

    // Вывод результата
    println("Зашифрованный текст: $encryptedText")
}
