/*
 * The MIT License
 *
 * Copyright 2016 Synclab Consulting LLC.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.conversationkit.impl.node;

import com.conversationkit.model.IConversationSnippetButton;
import com.conversationkit.model.IConversationState;
import com.conversationkit.model.SnippetContentType;
import com.conversationkit.model.SnippetType;
import java.util.ArrayList;
import java.util.List;

/**
 * A flexible implementation of <code>IConversationNode</code> that can 
 * specify but not 
 * require suggested answers to questions. However, no checks are made to ensure
 * that the suggested responses actually match an outbound edge.
 * 
 * @author pdtyreus
 */
public class ResponseSuggestingNode extends ConversationNode {

    protected List<String> suggestedResponses;
    protected List<IConversationSnippetButton> buttons;
    protected final String content;
    protected final SnippetContentType contentType;
    
    public ResponseSuggestingNode(int id, String content) {
        super(id);
        this.suggestedResponses = null;
        this.content = content;
        this.contentType = SnippetContentType.TEXT;
    }
    
    public ResponseSuggestingNode(int id, String content, SnippetContentType contentType) {
        super(id);
        this.suggestedResponses = null;
        this.content = content;
        this.contentType = contentType;
    }

    public String getValue() {
        return content;
    }

    public Iterable<String> getSuggestedResponses() {
        return suggestedResponses;
    }
    
    public void addSuggestedResponse(String response) {

        if (suggestedResponses == null) {
            suggestedResponses = new ArrayList();
        }
        suggestedResponses.add(response);
    }

    public Iterable<IConversationSnippetButton> getButtons() {
        return buttons;
    }
    
    public void addButton(ConversationNodeButton button) {
        if (buttons == null) {
            buttons = new ArrayList();
        }
        buttons.add(button);
    }
    
    public SnippetContentType getContentType() {
        return contentType;
    }
}
