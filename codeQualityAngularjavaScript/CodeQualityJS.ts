
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.
import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view';

// Here we can not just import Hook(function) if we have not any requirement in our file
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';

//Here we can not import components in multiple lines if it is easily do able in single way
// import statement hould be in alphabetical order
import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';


//All the import statement should be at the top.
import { selectedNoteSelector } from '../../src/selectors/notesSelector';


import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';




export const NoteListSize = 500;

//Here name of constant should be in lowercamelcase and another constant not saing what type of const we use for what purpose
const AnotherCOnst = 0.7;
//Import statement not in between code. All the import statement should be at the top
import { useSelector } from 'react-redux';

//We can define constant below import statement and all the constant should be at the same place
const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;

//Function component name is not too large. It should be small and have the same meaning as large function name convey 
//Function name start with lowercamelcase 
//In Arrow function the ()=>{ part should be in the first line
export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = (
  filters,sort,disablePagination,skip: boolean = false,
) => {
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);
  const TOTALNOTES = useRef<number>(0);
  //Below constant should be in one line 
  //Here the block statement noteFilters should be in one line 
  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;

  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;
   
  const prevPageSize =
  //This below line should in front of PrevPageSize
    numPriorItems < NoteListSize ? numPriorItems : NoteListSize;
  const shouldPrevPageLoad =
  CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination;

  //here the variable name shuould be appropriate random function does not convey anything what we are getting from useMemo function
  const randomFunction = useMemo(() => {
    let innerlist = CURRENT_PAGE.data
      .concat(
        addDebugInfo(CURRENT_PAGE?.data ?? [], {
          pageName: 'current',
          cached: CURRENT_PAGE === null,
        })
      )
    return innerlist;
  }, [
    disablePagination,
    startIndex,
    CURRENT_PAGE,
    isCurrentPageEmpty,
  ]);

  //Arrow function is not use like this it is in same line where we define our function 
  const result = useMemo(
    () => ({
      ...CURRENT_PAGE.data,
    }),
    [
      CURRENT_PAGE
    ]
  );
  return result;
};

function createPlaceholders(count: number, selectedID?: string | null): Result {
  const placeholders: Array<Record<string, unknown>> = new Array(count);
  placeholders
    .fill(
      {
        id: selectedID,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {
        id: undefined,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      1,
      count
    );
  return (placeholders as unknown) as Result;
}

function addDebugInfo(
  list: Result,
  debugInfo: {
    pageName: PageName;
    cached: boolean;
  }
): Result {
  if (debugPagination) {
    return list.map(item => ({ ...item, debugInfo }));
  }
  return list;
}
