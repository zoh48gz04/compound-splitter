package org.apache.lucene.analysis.de.compounds;

import java.util.Map;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.compound.CompoundWordTokenFilterBase;
import org.apache.lucene.analysis.util.TokenFilterFactory;

/**
 * Factory to construct a GraphGermanCompoundTokenFilter from configuration.
 * 
 * @author ben.demott
 */
public class GraphGermanCompoundTokenFilterFactory extends TokenFilterFactory {
    private final int minWordSize;
    private final boolean onlyLongestMatch;
    private final boolean preserveOriginal;
  
    /**
     * Construct filter factory (used in configuration based construction)
     * 
     * @param args input arguments from xml string
     */
    public GraphGermanCompoundTokenFilterFactory(Map<String, String> args) {
        super(args);
        
        // Pull arguments from args, providing defaults for when they aren't specified
        minWordSize = getInt(args, "minWordSize", GraphGermanCompoundTokenFilter.DEFAULT_MIN_WORD_SIZE);
        onlyLongestMatch = getBoolean(args, "onlyLongestMatch", GraphGermanCompoundTokenFilter.DEFAULT_ONLY_LONGEST_MATCH);
        preserveOriginal = getBoolean(args, "preserveOriginal", GraphGermanCompoundTokenFilter.DEFAULT_PRESERVE_ORIGINAL);
        if (!args.isEmpty()) {
            throw new IllegalArgumentException("There were unrecognized parameters, remove them: " + args);
        }
    }
  
    @Override
    public TokenStream create(TokenStream input) {
        return new GraphGermanCompoundTokenFilter(input,  minWordSize,  onlyLongestMatch, preserveOriginal);
    }
}