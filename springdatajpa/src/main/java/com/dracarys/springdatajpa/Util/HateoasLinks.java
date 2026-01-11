package com.dracarys.springdatajpa.Util;

import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

public class HateoasLinks {

    List<Link> links = new ArrayList<Link>();

    public void addLink(Link link) {
        links.add(link);
    }

    public List<Link> getLinks() {
        return links;
    }

}
