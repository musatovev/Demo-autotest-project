package autotest;

import java.util.ArrayList;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static utils.ResponseSpecifications.*;
import static steps.RequestActions.*;
import utils.ItemType;
import controller.Controller;
import lib.Responses.Folder.Folder;
import lib.Responses.Folder.EmbeddedItem;


@Epic("v1/disk/resources : Files and folders")
@Feature("Copy files")
public class CopyTests extends BaseTestClass {

    private final String homeFolderPath = "/";
    private final String expectedFolderPath = "/new";
    private String expectedFilePath;
    private EmbeddedItem file;

    @BeforeEach
    @Step("Preparing a file and folder for copying")
    public void before() {
        Folder homeFolder = get(Controller.RESOURCES, specWithPath(homeFolderPath), SIMPLE_OK())
                .extract().as(Folder.class);
        ArrayList<EmbeddedItem> files = homeFolder.getItemsByType(ItemType.FILE);

        if (files.size() < 1) {
            throw new AssertionError(
                    String.format("There are no files in directory \"%s\". You need to add the file before tests.", homeFolder));
        }

        // Create directory if it doesn't exist
        put(Controller.RESOURCES, specWithPath(expectedFolderPath), ITEM_CREATED_OR_EXISTED());

        file = files.get(0);
        expectedFilePath = expectedFolderPath + "/" + file.getName();

        // Delete the file in the directory, if it exists
        delete(Controller.RESOURCES, specWithPath(expectedFilePath), SIMPLE_ACCEPTED_OR_NOT_FOUND());
    }

    @AfterEach
    @Step("Delete the file in the directory, if it exists")
    public void after() {
        delete(Controller.RESOURCES, specWithPath(expectedFolderPath), SIMPLE_ACCEPTED_OR_NO_CONTENT());
    }

    @Test
    @Story("Success copy file")
    public void successCopyFile() {
        changeDefaultSpecification();
        specification
                .queryParam("from", file.getPath())
                .queryParam("path", expectedFilePath)
                .queryParam("overwrite", false);
        post(Controller.COPY, specification, SIMPLE_CREATED());

        // Check the hash of the copied file
        get(Controller.RESOURCES, specWithPath(expectedFolderPath), CHECK_SHA256(file));
    }

    @Test
    @Story("Success copy file with overwrite")
    public void successOverrideCopyFile() {
        changeDefaultSpecification();
        specification
                .queryParam("from", file.getPath())
                .queryParam("path", expectedFilePath)
                .queryParam("overwrite", false);
        post(Controller.COPY, specification, SIMPLE_CREATED());

        changeDefaultSpecification();
        specification
                .queryParam("from", file.getPath())
                .queryParam("path", expectedFilePath)
                .queryParam("overwrite", true);
        post(Controller.COPY, specification, SIMPLE_CREATED());

        // Check the hash of the copied file
        get(Controller.RESOURCES, specWithPath(expectedFolderPath), CHECK_SHA256(file));
    }

    @Test
    @Story("Copy file. Copy to not existent folder")
    public void copyFileAssertFolderNotExist() {
        String incorrectFolder = "/notExistFolder/" + expectedFilePath;
        changeDefaultSpecification();
        specification
                .queryParam("from", file.getPath())
                .queryParam("path", incorrectFolder)
                .queryParam("overwrite", false);
        post(Controller.COPY, specification, NOT_FOUND());

    }

    @Test
    @Story("Copy file. Copy not existent file")
    public void copyFileAssertFileNotExist() {
        String incorrectFile = "/notExistFile.jpg";
        changeDefaultSpecification();
        specification
                .queryParam("from", incorrectFile)
                .queryParam("path", expectedFilePath)
                .queryParam("overwrite", false);
        post(Controller.COPY, specification, NOT_FOUND());
    }

    @Test
    @Story("Copy file. File already exist, copy without overwrite")
    public void copyFileAssertFileAlreadyExistWithoutOverride() {
        changeDefaultSpecification();
        specification
                .queryParam("from", file.getPath())
                .queryParam("path", expectedFilePath)
                .queryParam("overwrite", false);
        post(Controller.COPY, specification, SIMPLE_CREATED());

        post(Controller.COPY, specification, ITEM_CREATED_OR_EXISTED());
    }

}
