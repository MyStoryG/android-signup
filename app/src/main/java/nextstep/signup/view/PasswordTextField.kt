package nextstep.signup.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.model.TextFieldState
import nextstep.signup.model.TextFieldType
import nextstep.signup.model.setMessage
import nextstep.signup.view.ui.theme.Red50
import nextstep.signup.view.ui.theme.SignupTheme

@Composable
fun PasswordContent(
    textState: String,
    onValueChange: (String) -> Unit = {},
    validationState: TextFieldState
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = textState,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.password)) },
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = if (validationState == TextFieldState.Valid || validationState == TextFieldState.Default) {
                MaterialTheme.colorScheme.primary
            } else {
                Red50
            }
        ),
        supportingText = {
            SignUpHelperText(
                setMessage(validationState, TextFieldType.Password)
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun PasswordTextFieldPreview() {
    SignupTheme {
        PasswordContent(
            textState = "",
            onValueChange = {},
            validationState = TextFieldState.Default
        )
    }
}