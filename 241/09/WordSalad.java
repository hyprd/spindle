package week09;

/**
 * Generate and manipulate word salad objects.
 *
 * @author Ethan Simmonds
 * @author Harry Smith
 * @author Mathew Clarke
 */
public class WordSalad implements Iterable<String> {
    /** First element of the WordSalad. */
    private WordNode first;
    /** Last element of the WordSalad. */
    private WordNode last;

    /**
     * Basic WordSalad constructor.
     */
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    /**
     * Construct WordSalad with a list of words.
     *
     * @param words A given list of String-type values
     */
    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    /**
     * Adds a string argument to the beginning of a list as a new traversable
     * node.
     *
     * @param word A user supplied argument to be passed to thier chosen word
     * salad
     */
    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    /**
     * Adds a string argument to the end of a list as a new traversable node.
     *
     * @param word A user supplied argument to be passed to thier chosen word
     * salad
     */
    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast;
    }

    /**
     * Definition for WordNode.
     */
    private class WordNode {
        /** A word in a WordSalad object. */
        private String word;
        /** Pointer to the next WordNode in a WordSalad object. */
        private WordNode next;

        /**
         * Generate a WordNode object .
         * @param word A word
         * @param next The next word
         */
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }

    }

    /**
     * Basic Iterator method.
     * @return whether next element exists; or the element itself.
     */
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            private WordNode current = first;

            public boolean hasNext() {
                return current != null;
            }

            public String next() {
                String result = current.word;
                current = current.next;
                return result;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * Return the results of a word salad as a string representation.
     *
     * @return A complete string representation
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        WordNode node = first;
        while (node != null) {
            result.append(node.word);
            result.append(node.next == null ? "" : ", ");
            node = node.next;
        }
        return result.toString() + "]";
    }

    /**
     * Distribute a word salad into an array of WordSalad objects.
     *
     * @param k Defines the length of blocks array (i.e. instances of WordSalad
     * objects)
     * @return The array of blocks
     */
    public WordSalad[] distribute(int k) {
        // Initialse the output vector.
        WordSalad[] blocks = new WordSalad[k];

        for (int i = 0; i < k; i++) {
            blocks[i] = new WordSalad(); // This is because defaults are null.
        }
        // End of initialisation.

        int arrayPointer = 0;
        WordNode current = this.first;

        while (current != null) {
            // Inline arrayPointer++ iterates AFTER the expression.
            blocks[arrayPointer++].addLast(current.word);
            current = current.next;

            // If the arrayPointer gets larger than the array, reset it.
            if (arrayPointer > k - 1) {
                arrayPointer = 0;
            }
        }

        return blocks;
    }

    /**
     * Splice a given sentence into an array of WordSalad objects.
     *
     * @param k Defines the length of block array (i.e. instances of WordSalad
     * objects)
     * @return The array of blocks
     */
    public WordSalad[] chop(int k) {
        // Initialse the output vector.
        WordSalad[] blocks = new WordSalad[k];

        for (int i = 0; i < k; i++) {
            blocks[i] = new WordSalad();
        }
        // End of initialisation.

        WordNode current = this.first;
        int wordTotal = 0;

        // Count the total number of words.
        while (current != null) {
            wordTotal++;
            current = current.next;
        }

        current = this.first; // Reset current to beginning of list.
        int extra = wordTotal % k; // Num of blocks that need an extra word.
        int even = wordTotal / k; // Base number of words.
        int currentBlock = 0;

        while (current != null) {
            // Gives the first blocks the extra words.
            if (currentBlock < extra) {
                for (int j = 0; j < even + 1; j++) {
                    blocks[currentBlock].addLast(current.word);
                    current = current.next;
                }
            } else { // Otherwise just the base num of words.
                for (int l = 0; l < even; l++) {
                    blocks[currentBlock].addLast(current.word);
                    current = current.next;
                }
            }

            currentBlock++;
        }

        return blocks;
    }

    /**
     * Splits a given sentence into an array of WordSalad objects.
     *
     * @param k The split factor
     * @return The array of blocks
     */
    public WordSalad[] split(int k) {
        // Init.
        WordNode current = this.first;
        int blocks = 0;
        int wordsInBlock = 0;
        int remainingWords;
        int totalWords = 0;
        int iteratorWord = 0;
        WordSalad temp = new WordSalad();
        WordSalad working = this;
         // End of init.

        // Count total number of words.
        while (current != null) {
            totalWords++;
            current = current.next;
        }

        remainingWords = totalWords;

        // Find total number of blocks.
        while (remainingWords > 0) {
            blocks++;
            iteratorWord = remainingWords;
            wordsInBlock = 0;

            while (iteratorWord > 0) { // Similar to distribute.
                wordsInBlock++;
                iteratorWord -= k;
            }

            remainingWords -= wordsInBlock;
        }

        // Setting up output array.
        WordSalad[] out = new WordSalad[blocks];

        for (int i = 0; i < out.length; i++) {
            out[i] = new WordSalad();
        }
        // End of setup.

        int iter;

        for (int j = 0; j < blocks; j++) {
            iter = 0;                // Reset.
            current = working.first; // Reset.

            while (current != null) {
                // If in first group, add to first group.
                if (iter == 0) {
                    out[j].addLast(current.word);
                } else { // Else discard and add to remainder.
                    temp.addLast(current.word);
                }
                current = current.next;
                iter++;

                if (iter == k) { // Because you distribute to k blocks.
                    iter = 0;
                }
            }

            // Take remainder of words that were not allocated.
            working = temp;
            temp = new WordSalad();
        }
        return out;
    }

    /**
     * Merges an array of blocks into one instance.
     *
     * @param blocks A given array of WordSalad instances
     * @return An instance of WordSalad, a product of marging each block into
     * one
     */
    public static WordSalad merge(WordSalad[] blocks) {
        // Init.
        WordSalad out = new WordSalad();
        WordNode[] pointers = new WordNode[blocks.length];
        boolean done;

        // Keep an array of all of the block' current position.
        for (int i = 0; i < pointers.length; i++) {
            // Sets all pointers to start of salads.
            pointers[i] = blocks[i].first;
        }
        // End of init.

        while (true) {
            done = true;
            for (int j = 0; j < blocks.length; j++) {
                if (pointers[j] != null) {
                    out.addLast(pointers[j].word);
                    pointers[j] = pointers[j].next;
                    done = false;
                }
            }

            if (done) { // If all pointers are null, we are done.
                break;
            }
        }

        return out;
    }

    /**
     * Join the given array of blocks into a single WordSalad object.
     *
     * @param blocks A given array of WordSalad instances
     * @return An instance of WordSalad, a product of joining each block into
     * one
     */
    public static WordSalad join(WordSalad[] blocks) {
        // Initialise output object.
        WordSalad out = new WordSalad();

        // For every block, add all of the blocks' words
        // (in sequence) to the output block.
        for (int i = 0; i < blocks.length; i++) {
            WordNode current = blocks[i].first; // Pointer used for iterator.

            while (current != null) {
                out.addLast(current.word);
                current = current.next; // Iterates though the block.
            }
        }

        return out;
    }

    /**
     * Join the given array of blocks into a single WordSalad object. This
     * performs the inverse of the split method.
     *
     * @param blocks A given array of WordSalad instances
     * @param k The split factor
     * @return An instance of WordSalad, a product of combining each block into
     * one
     */
    public static WordSalad recombine(WordSalad[] blocks, int k) {
        return null;
    }

}
