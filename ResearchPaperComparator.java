package researcher;

import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Date;
import java.util.Set;

import employee.*;
import enums.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;

import java.io.Serializable;
import java.util.Comparator;

public class ResearchPaperComparator implements Comparator<ResearchPaper>,Serializable {

    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getCitations(), paper2.getCitations());
    }
}

