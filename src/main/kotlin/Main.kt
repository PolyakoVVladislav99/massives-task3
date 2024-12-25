fun main() {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    val alphabetSize = alphabet.length

    println("Введите ключевое слово:")
    val keyWord = readLine()?.uppercase() ?: ""

    println("Введите исходный текст:")
    val sourceText = readLine()?.uppercase() ?: ""

    if (keyWord.isEmpty() || sourceText.isEmpty()) {
        println("Ошибка: ключевое слово и исходный текст не могут быть пустыми.")
        return
    }

    val shifts = keyWord.map { alphabet.indexOf(it) + 1 }

    val encryptedText = StringBuilder()
    for (i in sourceText.indices) {
        val char = sourceText[i]
        val shift = shifts[i % shifts.size]

        if (char in alphabet) {
            val newIndex = (alphabet.indexOf(char) + shift) % alphabetSize
            encryptedText.append(alphabet[newIndex])
        } else {
            encryptedText.append(char) 
        }
    }

    println("Зашифрованный текст: $encryptedText")
}
