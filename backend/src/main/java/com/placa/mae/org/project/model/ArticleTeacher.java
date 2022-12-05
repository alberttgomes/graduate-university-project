package com.placa.mae.org.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materialTeacher", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title"})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adolescentId;
    @Column(name = "title", length = 25, nullable = false)
    private String title;
    @Column(name = "articlesInPDF")
    private List<AbstractPdfView> pdf = new ArrayList<>();
    @Column(name = "fileWay")
    private List<String> fileWay = new ArrayList<>();

}
