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
package com.conversationkit.model;

import com.eclipsesource.json.JsonObject;

/**
 * A conversation node is a vertex on the directed conversation graph containing
 * a statement or question for the bot to present to the user. Each node has
 * zero or more outbound edges and zero or more inbound edges. The conversation
 * traverses the graph between nodes in by analyzing the state and choosing
 * the first matching edge at each vertex.
 * @author pdtyreus
 * @param <E> generic type of the node's edges
 */
public interface IConversationNode<E extends IConversationEdge> {

    /**
     * Returns a list of outbound edges from the current node. One matching 
     * edge may be chosen to continue the conversation to the next node.
     * @return outbound edges
     */
    public Iterable<E> getEdges();

    /**
     * Adds an edge to the list of possible outbound edges.
     * @param edge edge to add
     */
    public void addEdge(E edge);

    /**
     * Returns the unique identifier for this node.
     * @return the node id
     */
    public int getId();
    
    /**
     * Node metadata is any additional information the node may
     * need to build platform-specific implementations of itself. The values stored
     * in the metadata will be highly dependent on the final use case and is
     * designed to be highly flexible. 
     * @return 
     */
    public JsonObject getMetadata();
    
}
