package com.reason.ocaml;

import com.reason.BaseParsingTestCase;
import com.reason.lang.core.psi.PsiType;
import com.reason.lang.ocaml.OclParserDefinition;

import java.util.Collection;

public class RecursiveTypeTest extends BaseParsingTestCase {
    public RecursiveTypeTest() {
        super("", "ml", new OclParserDefinition());
    }

    public void testAnd() {
        Collection<PsiType> types = typeExpressions(parseCode("type update = | NoUpdate and 'state self = {state: 'state;}"));

        assertEquals(2, types.size());
        assertEquals("update", first(types).getName());
        assertEquals("self", second(types).getName());
    }
}
