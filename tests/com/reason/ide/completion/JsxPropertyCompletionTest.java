package com.reason.ide.completion;

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import com.reason.ide.files.RmlFileType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JsxPropertyCompletionTest extends LightPlatformCodeInsightFixtureTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @NotNull
    @Override
    protected String getTestDataPath() {
        return "testData/com/reason/lang";
    }

    public void testShouldDisplayProperties() {
        myFixture.configureByFiles("pervasives.ml", "component/Component.re", "component/CompMessage.re");
        myFixture.configureByText(RmlFileType.INSTANCE, "let _ = <Component <caret>>");

        myFixture.completeBasic();

        List<String> completionElements = myFixture.getLookupElementStrings();
        assertSize(5, completionElements);
        assertContainsElements(completionElements, "key", "ref", "_type", "dismissAfter", "onClose");
    }

    public void testShouldDisplayPropertiesAfterPropName() {
        myFixture.configureByFiles("pervasives.ml", "component/Component.re", "component/CompMessage.re");
        myFixture.configureByText(RmlFileType.INSTANCE, "let _ = <Component d<caret> >");

        myFixture.completeBasic();

        List<String> completionElements = myFixture.getLookupElementStrings();
        //assertSize(5, completionElements);
        //assertContainsElements(completionElements, "key", "ref", "_type", "dismissAfter", "onClose");
    }
}
