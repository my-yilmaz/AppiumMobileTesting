package pages;

import pages.android.*;

public class Screens {
    public Screens() {
    }

    private ApiDemosPage apiDemosPage;
    private MainPage mainPage;
    private PreferencePage preferencePage;
    private PreferenceDependenciesPage preferenceDependenciesPage;
    private SwitchPage switchPage;
    private ViewPage viewPage;
    private DragAndDropPage dragAndDropPage;
    private DateWidgetsPage dateWidgetsPage;
    private PopupMenuPage popupMenuPage;

    public ApiDemosPage apiDemosPage() {
        if (apiDemosPage == null) {
            apiDemosPage = new ApiDemosPage();
        }
        return apiDemosPage;
    }

    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public PreferencePage preferencePage() {
        if (preferencePage == null) {
            preferencePage = new PreferencePage();
        }
        return preferencePage;
    }

    public PreferenceDependenciesPage preferenceDependenciesPage() {
        if (preferenceDependenciesPage == null) {
            preferenceDependenciesPage = new PreferenceDependenciesPage();
        }
        return preferenceDependenciesPage;
    }

    public DateWidgetsPage dateWidgetsPage() {
        if (dateWidgetsPage == null) {
            dateWidgetsPage = new DateWidgetsPage();
        }
        return dateWidgetsPage;
    }

    public PopupMenuPage popupMenuPage() {
        if (popupMenuPage == null) {
            popupMenuPage = new PopupMenuPage();
        }
        return popupMenuPage;
    }

    public DragAndDropPage dragAndDropPage() {
        if (dragAndDropPage == null) {
            dragAndDropPage = new DragAndDropPage();
        }
        return dragAndDropPage;
    }

    public SwitchPage switchPage() {
        if (switchPage == null) {
            switchPage = new SwitchPage();
        }
        return switchPage;
    }

    public ViewPage viewPage() {
        if (viewPage == null) {
            viewPage = new ViewPage();
        }
        return viewPage;
    }
}
