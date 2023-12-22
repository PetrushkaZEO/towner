package gg.towner.gamelogic;

import gg.towner.gamelogic.gameui.GameButtonUi;
import javafx.scene.Group;

public class BuildMenu {

    private GameButtonUi buildButton;
    private GameButtonUi houseBuildSlot;
    private GameButtonUi closeButton;
    private GameButtonUi foundButton;
    private GameButtonUi foundButtonClose;
    public void createMenu(Group group){
        createButtons(group);
        registerButtonEvents(group);
    }

    private void createButtons(Group group){
        buildButton = new GameButtonUi(50, 750, 55, 55, "buttons/BuildButton.png", "buttons/BuildButton.png", "buttons/BuildButton.png");
        buildButton.hide(group);
        houseBuildSlot = new GameButtonUi(380, 750, 55, 55, "buttons/PanelButton.png", "buttons/PanelButton.png", "buttons/PanelButton.png");
        houseBuildSlot.hide(group);
        closeButton = new GameButtonUi(50, 750, 55, 55, "buttons/CloseButton.png", "buttons/CloseButton.png", "buttons/CloseButton.png");
        closeButton.hide(group);
        foundButton = new GameButtonUi(300, 750, 55, 55, "buttons/foundButton_def.png", "buttons/foundButton_enter.png", "buttons/foundButton_click.png");
        foundButton.hide(group);
        foundButtonClose = new GameButtonUi(300, 750, 60, 60, "buttons/CloseButton.png", "buttons/CloseButton.png", "buttons/CloseButton.png");
        foundButtonClose.hide(group);
    }

    public void moveButtons(double x, double y){
        buildButton.getButtonView().setTranslateX(buildButton.getButtonView().getTranslateX() + x);
        buildButton.getButtonView().setTranslateY(buildButton.getButtonView().getTranslateY() + y);
        houseBuildSlot.getButtonView().setTranslateX(houseBuildSlot.getButtonView().getTranslateX() + x);
        houseBuildSlot.getButtonView().setTranslateY(houseBuildSlot.getButtonView().getTranslateY() + y);
        closeButton.getButtonView().setTranslateX(closeButton.getButtonView().getTranslateX() + x);
        closeButton.getButtonView().setTranslateY(closeButton.getButtonView().getTranslateY() + y);
    }

    public void setButtonPositions(double x, double y){
        buildButton.getButtonView().setTranslateX(x);
        buildButton.getButtonView().setTranslateY(y);
        houseBuildSlot.getButtonView().setTranslateX(x + 330);
        houseBuildSlot.getButtonView().setTranslateY(y);
        closeButton.getButtonView().setTranslateX(x);
        closeButton.getButtonView().setTranslateY(y);
    }

    public void moveFoundButtonPos(double x, double y){
        foundButton.getButtonView().setTranslateX(foundButton.getButtonView().getTranslateX() + x);
        foundButton.getButtonView().setTranslateY(foundButton.getButtonView().getTranslateY() + y);
        foundButtonClose.getButtonView().setTranslateX(foundButtonClose.getButtonView().getTranslateX() + x);
        foundButtonClose.getButtonView().setTranslateY(foundButtonClose.getButtonView().getTranslateY() + y);
    }

    public void setFoundButtonPositions(double x, double y){
        foundButton.getButtonView().setTranslateX(x);
        foundButton.getButtonView().setTranslateY(y);
        foundButtonClose.getButtonView().setTranslateX(x);
        foundButtonClose.getButtonView().setTranslateY(y);
    }


    private void registerButtonEvents(Group group){
        buildButton.getButtonView().setOnMouseClicked(event -> {
            showMenu(group);
        });
        closeButton.getButtonView().setOnMouseClicked(event -> {
            hideMenu(group);
        });
        foundButton.getButtonView().setOnMouseEntered(event -> {
            foundButton.setMouseEnterTexture();
        });
        foundButton.getButtonView().setOnMouseExited(event -> {
            foundButton.setDefaultTexture();
        });
        foundButton.getButtonView().setOnMouseClicked(event -> {
            foundButton.setMouseClickedTexture();
            showFoundMenu(group);
        });
        foundButton.getButtonView().setOnMousePressed(event -> {
            foundButton.setMouseClickedTexture();
        });
        foundButton.getButtonView().setOnMouseReleased(event -> {
            foundButton.setDefaultTexture();
        });
        foundButtonClose.getButtonView().setOnMouseClicked(event -> {
            hideFoundMenu(group);
        });


    }

    private boolean isVisible = true;
    public void showMenu(Group group){
        buildButton.hide(group);
        closeButton.show(group);
        houseBuildSlot.show(group);
    }

    public void hideMenu(Group group){
        buildButton.show(group);
        closeButton.hide(group);
        houseBuildSlot.hide(group);
    }

    public void showFoundMenu(Group group){
        foundButton.hide(group);
        foundButtonClose.show(group);
        Player.isBuildMode = true;
    }
    public void hideFoundMenu(Group group){
        foundButton.show(group);
        foundButtonClose.hide(group);
        Player.isBuildMode = false;
    }
    private boolean isFoundMenuVisible = true;
    public void invisibleFoundMenu(){
        if(!isFoundMenuVisible) return;
        foundButton.getButtonView().setVisible(false);
        foundButtonClose.getButtonView().setVisible(false);
        isFoundMenuVisible = false;
    }
    public void visibleFoundMenu(){
        if(isFoundMenuVisible) return;
        foundButton.getButtonView().setVisible(true);
        foundButtonClose.getButtonView().setVisible(true);
        isFoundMenuVisible = true;
    }

    public void invisibleMenu(){
        if(!isVisible) return;
        houseBuildSlot.getButtonView().setVisible(false);
        closeButton.getButtonView().setVisible(false);
        buildButton.getButtonView().setVisible(false);
        isVisible = false;
    }
    public void visibleMenu(){
        if(isVisible) return;
        buildButton.getButtonView().setVisible(true);
        houseBuildSlot.getButtonView().setVisible(true);
        closeButton.getButtonView().setVisible(true);
        isVisible = true;
    }


    public GameButtonUi getBuildButton() {
        return buildButton;
    }

    public GameButtonUi getHouseBuildSlot() {
        return houseBuildSlot;
    }

    public GameButtonUi getCloseButton() {
        return closeButton;
    }
}
