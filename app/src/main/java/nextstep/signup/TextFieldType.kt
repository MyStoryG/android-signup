package nextstep.signup

sealed class TextFieldType {
    data object Username : TextFieldType()
    data object Email : TextFieldType()
    data object Password : TextFieldType()
}