package com.utils.coders.android_extensions

import org.junit.Test

import org.junit.Assert.*

class StringExtensionTests {
    @Test
    fun enough_characters_and_numbers() {
        val password = "mypassword1234"
        assertEquals(true, password.isValidPassword())
    }

    @Test
    fun only_characters() {
        val password = "mypassword"
        assertEquals(false, password.isValidPassword())
    }

    @Test
    fun only_numbers() {
        val password = "1234"
        assertEquals(false, password.isValidPassword())
    }

    @Test
    fun alphanumeric_less_than_eight_characters() {
        val password = "ab1234"
        assertEquals(false, password.isValidPassword())
    }

    @Test
    fun valid_email_should_return_true() {
        val email = "test@2coders.com"
        assertEquals(true, email.isValidEmail())
    }

    @Test
    fun invalid_email_should_return_false() {
        val email = "test@2coderscom"
        assertEquals(false, email.isValidEmail())
    }

    @Test
    fun alphanumeric_username_with_alphanumeric_validation_should_return_true() {
        assertEquals(true, "usertest12".isValidUsername())
    }

    @Test
    fun alphanumeric_username_with_strange_characters_should_return_false() {
        assertEquals(false, "user.test12".isValidUsername())
    }

    @Test
    fun numeric_username_with_numeric_validation_should_return_true() {
        assertEquals(true, "23452234".isValidUsername(UsernameType.NUMERIC))
    }

    @Test
    fun numeric_username_with_strange_characters_should_return_false() {
        assertEquals(false, "12345.231".isValidUsername(UsernameType.NUMERIC))
    }

    @Test
    fun character_username_with_character_validation_should_return_true() {
        assertEquals(true, "thisismyusername".isValidUsername(UsernameType.CHARACTERS))
    }

    @Test
    fun character_username_with_strange_characters_should_return_false() {
        assertEquals(false, "thisi-.smyusername".isValidUsername(UsernameType.CHARACTERS))
    }

    @Test
    fun any_username_with_less_characters_than_eight_should_return_false() {
        assertEquals(false, "user12".isValidUsername())
        assertEquals(false, "user".isValidUsername(UsernameType.CHARACTERS))
        assertEquals(false, "1234".isValidUsername(UsernameType.NUMERIC))
    }

}