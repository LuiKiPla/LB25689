package com.Product;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="box")
@XmlAccessorType(XmlAccessType.FIELD)
public class Box extends Product {
    @XmlElementWrapper(name = "contents")
    @XmlElement(name = "content")
    List<String> contents;

    public Box() {
        super();
    };
    public Box(String name, double weight, List<String> contents) {
        super(name, weight);
        this.contents = contents;
    }

    @Override
    public String getDetails() {
        String contents = new String();
        for (String content: this.contents) {
            if (content != this.contents.get(this.contents.size()-1)) {
                contents += content + " ";
            }
            else {
                contents += content;
            }
        }
        return "Коробка весом " + weight + "кг с " + this.contents.size() + " c типом товаров " +this.name +  ": " + contents;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Box box = (Box) o;
        return Objects.equals(contents, box.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contents);
    }
}
