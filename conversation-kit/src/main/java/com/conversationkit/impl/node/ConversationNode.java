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

import com.conversationkit.model.IConversationEdge;
import com.conversationkit.model.IConversationNode;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Convenience base class for creating nodes.
 *
 * @author pdtyreus
 */
public class ConversationNode implements IConversationNode {

    protected final List<IConversationEdge> edges;
    private final int id;
    private final JsonObject metadata;

    public ConversationNode(int id) {
        this.id = id;
        this.edges = new ArrayList();
        this.metadata = new JsonObject();
    }

    public ConversationNode(int id, JsonObject metadata) {
        this.id = id;
        this.edges = new ArrayList();
        this.metadata = metadata;
    }

    @Override
    public Iterable<IConversationEdge> getEdges() {
        return edges;
    }

    @Override
    public void addEdge(IConversationEdge edge) {
        edges.add(edge);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public JsonObject getMetadata() {
        return metadata;
    }

}
