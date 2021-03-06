/****************************************************************************
 Copyright (c) 2018 Xiamen Yaji Software Co., Ltd.

 http://www.cocos2d-x.org
 
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 
 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 ****************************************************************************/

#include "RenderBuffer.h"
#include "GFXUtils.h"

RENDERER_BEGIN

RenderBuffer::RenderBuffer()
: _device(nullptr)
, _format(Format::RGBA4)
, _width(0)
, _height(0)
{

}

RenderBuffer::~RenderBuffer()
{
    if (_glID == 0)
    {
        RENDERER_LOGE("The render-buffer (%p) is invalid!", this);
        return;
    }

    GL_CHECK(glDeleteRenderbuffers(1, &_glID));
}

bool RenderBuffer::init(DeviceGraphics* device, Format format, uint16_t width, uint16_t height)
{
    _device = device;
    _format = format;
    _width = width;
    _height = height;
    
    GLint oldRenderBuffer;
    glGetIntegerv(GL_RENDERBUFFER_BINDING, &oldRenderBuffer);
    GL_CHECK(glGenRenderbuffers(1, &_glID));
    GL_CHECK(glBindRenderbuffer(GL_RENDERBUFFER, _glID));
    GL_CHECK(glRenderbufferStorage(GL_RENDERBUFFER, (GLenum)format, width, height));
    GL_CHECK(glBindRenderbuffer(GL_RENDERBUFFER, oldRenderBuffer));
    return true;
}

bool RenderBuffer::update (uint16_t width, uint16_t height) {
    _width = width;
    _height = height;

    GLint oldRenderBuffer;
    glGetIntegerv(GL_RENDERBUFFER_BINDING, &oldRenderBuffer);
    GL_CHECK(glBindRenderbuffer(GL_RENDERBUFFER, _glID));
    GL_CHECK(glRenderbufferStorage(GL_RENDERBUFFER, (GLenum)_format, width, height));
    GL_CHECK(glBindRenderbuffer(GL_RENDERBUFFER, oldRenderBuffer));
    return true;
}

RENDERER_END
