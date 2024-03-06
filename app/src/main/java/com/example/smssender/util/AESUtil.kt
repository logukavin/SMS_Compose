package com.example.smssender.util

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import android.util.Base64


object AESUtil {

    // Encrypt message using AES encryption
    fun encryptMessage(message: String, secretKey: String): String {
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        val keySpec = SecretKeySpec(secretKey.toByteArray(), "AES")
        cipher.init(Cipher.ENCRYPT_MODE, keySpec)

        val encryptedBytes = cipher.doFinal(message.toByteArray())
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT)
    }

    // Decrypt message using AES encryption
    fun decryptMessage(encryptedMessage: String, secretKey: String): String {
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        val keySpec = SecretKeySpec(secretKey.toByteArray(), "AES")
        cipher.init(Cipher.DECRYPT_MODE, keySpec)

        val decryptedBytes = cipher.doFinal(Base64.decode(encryptedMessage, Base64.DEFAULT))
        return String(decryptedBytes)
    }

}