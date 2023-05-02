package org.tarantsov;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class SampleAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        final PsiFile psiFile = e.getRequiredData(CommonDataKeys.PSI_FILE);
        final Document document = editor.getDocument();
        final String fileContent = document.getText(); // Отримуємо весь текстовий вміст файлу

        // Тут можна виконати потрібні преобразування для fileContent
        String updatedText = processText(fileContent);
        // Зберігаємо зміни в файлі
        WriteCommandAction.runWriteCommandAction(e.getProject(), () -> document.setText(updatedText));
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        final PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        e.getPresentation().setEnabledAndVisible(editor != null && psiFile != null);
    }


/*
    @Override
    public void update(@NotNull AnActionEvent e) {
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        e.getPresentation().setEnabled(editor != null && editor.getSelectionModel().hasSelection());
    }
*/

    private String processText(String input) {
        // Тут ви можете реалізувати вашу функцію для обробки тексту на основі вашого JS-коду.
        // Це лише приклад, який робить текст у верхньому регістрі.
        return input.toUpperCase();
    }
}
